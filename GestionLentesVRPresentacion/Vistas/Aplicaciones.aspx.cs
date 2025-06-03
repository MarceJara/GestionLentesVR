using System;
using System.Collections.Generic;
using System.Globalization;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace FrontVR.Vistas
{
    public partial class Aplicaciones : Page
    {
        // Servicio en memoria de prueba ─ reemplázalo por tu capa real
        private readonly IAplicacionService _service = new AplicacionService();

        protected void Page_Load(object sender, EventArgs e)
        {
            if (!IsPostBack) BindGrid();
        }

        private void BindGrid()
        {
            gvAplicaciones.DataSource = _service.Listar();
            gvAplicaciones.DataBind();
        }

        // ========= NUEVA APP =========
        protected void btnGuardar_Click(object sender, EventArgs e)
        {
            // Validación mínima
            if (string.IsNullOrWhiteSpace(txtNombre.Text))
            {
                lblError.Text = "El nombre es obligatorio.";
                lblError.Visible = true;
                return;
            }

            if (!double.TryParse(txtTamano.Text, NumberStyles.Any,
                                 CultureInfo.InvariantCulture,
                                 out double tamMb))
            {
                lblError.Text = "Tamaño inválido.";
                lblError.Visible = true;
                return;
            }

            var dto = new AplicacionDto
            {
                Nombre = txtNombre.Text.Trim(),
                Version = txtVersion.Text.Trim(),
                TamanoMb = tamMb,
                Estado = "Disponible"
            };

            try
            {
                _service.Crear(dto, User.Identity.Name);
                ClearModal();

                // Cierra modal por JS y refresca tabla
                ScriptManager.RegisterStartupScript(
                    this, GetType(), "CerrarModal",
                    "$('#modalNuevaApp').modal('hide');", true);

                BindGrid();
            }
            catch (Exception ex)
            {
                lblError.Text = "Error: " + ex.Message;
                lblError.Visible = true;
            }
        }

        private void ClearModal()
        {
            txtNombre.Text = txtVersion.Text = txtTamano.Text = string.Empty;
            lblError.Visible = false;
        }

        // ========= ACCIÓN INSTALAR/DESINSTALAR =========
        protected void gvAplicaciones_RowCommand(object sender, GridViewCommandEventArgs e)
        {
            if (e.CommandName != "ToggleInstall") return;

            int id = Convert.ToInt32(e.CommandArgument);
            _service.ToggleInstall(id, User.Identity.Name);
            BindGrid();
        }

        // Helper para pintar badge con Bootstrap
        protected string GetBadgeCss(object estadoObj)
        {
            var estado = estadoObj?.ToString();
            return estado == "Instalada" ? "badge bg-success" : "badge bg-secondary";
        }
    }
}

/* -------------------------------------------------------------------------
   ███  DTO y servicio en memoria  (solo uso rápido / pruebas locales)  ███
   ------------------------------------------------------------------------- */

internal class AplicacionDto
{
    public int Id { get; set; }
    public string Nombre { get; set; }
    public string Version { get; set; }
    public double TamanoMb { get; set; }
    public string Estado { get; set; }   // "Instalada" | "Disponible"
}

internal interface IAplicacionService
{
    IEnumerable<AplicacionDto> Listar();
    void Crear(AplicacionDto dto, string usuario);
    void ToggleInstall(int idAplicacion, string usuario);
}

internal class AplicacionService : IAplicacionService
{
    // Simula una base de datos en memoria
    private static readonly List<AplicacionDto> _data;// = new();

    public IEnumerable<AplicacionDto> Listar() => _data;

    public void Crear(AplicacionDto dto, string usuario)
    {
        dto.Id = _data.Count + 1;
        _data.Add(dto);
    }

    public void ToggleInstall(int idAplicacion, string usuario)
    {
        var app = _data.Find(a => a.Id == idAplicacion);
        if (app != null)
        {
            app.Estado = app.Estado == "Instalada" ? "Disponible" : "Instalada";
        }
    }
}
