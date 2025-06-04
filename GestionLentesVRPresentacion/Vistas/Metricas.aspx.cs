//using Newtonsoft.Json;
using System;
using System.Collections.Generic;
using System.Globalization;
using System.Linq;
using System.Text.Json;
using System.Web.UI;

namespace FrontVR.Vistas
{
    public partial class Metricas : Page
    {
        private readonly IMetricasService _service = new MetricasService(); // stub/local

        protected void Page_Load(object sender, EventArgs e)
        {
            if (!IsPostBack) CargarDashboard();
        }

        private void CargarDashboard()
        {
            // ► Detalle y KPIs
            var lista = _service.Listar();
            gvMetricas.DataSource = lista;
            gvMetricas.DataBind();

            lblTotalDisp.Text = lista.Count.ToString(CultureInfo.InvariantCulture);
            lblHorasHoy.Text = _service.ObtenerHorasHoy().ToString("N1", CultureInfo.InvariantCulture);
            lblAppsHoy.Text = _service.ObtenerAppsHoy().ToString(CultureInfo.InvariantCulture);

            // ► Dataset para el chart
            var datosJson = JsonSerializer.Serialize(
                lista.Select(d => new { nombre = d.Nombre, horas = d.TiempoActivoHorasSemanal })
            );

            RegistrarScriptChart(datosJson);
        }

        /* ---------- Inyección del script ---------- */
        private void RegistrarScriptChart(string datosJson)
        {
            var script = $@"
                (function () {{
                    const datos = {datosJson};
                    const ctx   = document.getElementById('chartHoras').getContext('2d');

                    new Chart(ctx, {{
                        type: 'bar',
                        data: {{
                            labels: datos.map(d => d.nombre),
                            datasets: [{{
                                label: 'Horas',
                                data:  datos.map(d => d.horas)
                            }}]
                        }},
                        options: {{
                            plugins: {{ legend: {{ display: false }} }},
                            scales:  {{ y: {{ beginAtZero: true }} }}
                        }}
                    }});
                }})();";

            ScriptManager.RegisterStartupScript(this, GetType(), "initChart", script, true);
        }
    }
}

/* ------------------------------------------------------------------ */
/*                        DTO + Servicio stub                         */
/* ------------------------------------------------------------------ */
internal class MetricaDispositivoDto
{
    public int Id { get; set; }
    public string Nombre { get; set; }
    public double TiempoActivoHoras { get; set; }
    public double TiempoActivoHorasSemanal { get; set; }
    public int AppsEjecutadas { get; set; }
    public DateTime UltimaConexion { get; set; }
}

internal interface IMetricasService
{
    IList<MetricaDispositivoDto> Listar();
    double ObtenerHorasHoy();
    int ObtenerAppsHoy();
}

/* Servicio temporal en memoria */
internal class MetricasService : IMetricasService
{
    private static readonly Random _rnd;// = new();        // 1️⃣ primero

    private static readonly IList<MetricaDispositivoDto> _data =   // 2️⃣ después
        Enumerable.Range(1, 6)
                  .Select(i => new MetricaDispositivoDto
                  {
                      Id = i,
                      Nombre = $"Meta Quest {i}",
                      TiempoActivoHoras = _rnd.NextDouble() * 300,
                      TiempoActivoHorasSemanal = _rnd.NextDouble() * 25,
                      AppsEjecutadas = _rnd.Next(50, 200),
                      UltimaConexion = DateTime.Now.AddMinutes(-_rnd.Next(5, 480))
                  })
                  .ToList();

    public IList<MetricaDispositivoDto> Listar() => _data;
    public double ObtenerHorasHoy() => _data.Sum(d => d.TiempoActivoHorasSemanal / 7);
    public int ObtenerAppsHoy() => _data.Sum(d => d.AppsEjecutadas / 30);
}
