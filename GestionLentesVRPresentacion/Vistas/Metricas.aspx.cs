using System;
using System.Web.UI;

namespace FrontVR.Vistas
{
    public partial class Metricas : Page
    {
        protected void Page_Load(object sender, EventArgs e)
        {
            if (Session["usuario"] == null)
                Response.Redirect("~/Login.aspx");

            if (!IsPostBack)
            {
                // Cargar datos aquí si es necesario
            }
        }
    }
}
