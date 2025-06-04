using System;
using System.Collections.Generic;
using System.Linq;
using System.Web.UI;
using FrontVR.DispositivosWS;

namespace FrontVR.Vistas
{
    public partial class Dispositivos : System.Web.UI.Page
    {
        private DispositivoWSClient servicio = new DispositivoWSClient();

        protected void Page_Load(object sender, EventArgs e)
        {
            if (!IsPostBack)
            {
                CargarDispositivos();
            }
        }

        private void CargarDispositivos()
        {
            var lista = servicio.listarDispositivo().ToList();
            gvDispositivos.DataSource = lista;
            gvDispositivos.DataBind();
        }

        protected void btnGuardar_Click(object sender, EventArgs e)
        {
            grupo grupo = new grupo();
            grupo.grupoId = 2;
            dispositivo d = new dispositivo
            {
                dispositivoId = string.IsNullOrWhiteSpace(txtId.Text) ? 0 : int.Parse(txtId.Text),
                nombre = txtNombre.Text,
                modelo = txtModelo.Text,
                numeroSerie = txtSerie.Text,
                fechaRegistro = DateTime.Parse(txtFecha.Text),
                ubicacion = txtUbicacion.Text,
                ultimaConexion = DateTime.Now,
                activo = true,
                ultimaConexionSpecified = true,
                grupo = grupo,
                firmwareActual = new firmware
                {
                    firmwareId = 1 // Solo referencia, sin detalles
                }
            };

            if (d.dispositivoId == 0)
                servicio.registrarDispositivo(d);
            else
                servicio.actualizarDispositivo(d);

            LimpiarFormulario();
            CargarDispositivos();
        }


        protected void gvDispositivos_RowCommand(object sender, System.Web.UI.WebControls.GridViewCommandEventArgs e)
        {
            int index = Convert.ToInt32(e.CommandArgument);
            int id = int.Parse(gvDispositivos.Rows[index].Cells[0].Text);

            if (e.CommandName == "Editar")
            {
                var d = servicio.obtenerDispositivo(id);
                txtId.Text = d.dispositivoId.ToString();
                txtNombre.Text = d.nombre;
                txtModelo.Text = d.modelo;
                txtSerie.Text = d.numeroSerie;
                txtFecha.Text = d.fechaRegistro.ToString("yyyy-MM-dd");
                txtUbicacion.Text = d.ubicacion;
            }
            else if (e.CommandName == "Eliminar")
            {
                servicio.eliminarDispositivo(id);
                CargarDispositivos();
            }
        }

        private void LimpiarFormulario()
        {
            txtId.Text = "";
            txtNombre.Text = "";
            txtModelo.Text = "";
            txtSerie.Text = "";
            txtFecha.Text = "";
            txtUbicacion.Text = "";
        }
    }
}
