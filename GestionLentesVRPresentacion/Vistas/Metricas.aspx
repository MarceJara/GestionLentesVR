<%@ Page Language="C#"
         MasterPageFile="~/Site.Master"
         AutoEventWireup="true"
         CodeBehind="Metricas.aspx.cs"
         Inherits="FrontVR.Vistas.Metricas" %>

<asp:Content ID="Main" ContentPlaceHolderID="MainContent" runat="server">

    <h2 class="mb-4">Dashboard de Métricas</h2>

    <!-- ===== KPI CARDS ===== -->
    <div class="row g-3 mb-4">
        <div class="col-md-4">
            <div class="card bg-dark border-secondary text-white text-center shadow-sm">
                <div class="card-body">
                    <h5 class="card-title">Dispositivos registrados</h5>
                    <asp:Label ID="lblTotalDisp" runat="server" CssClass="display-6 fw-bold" />
                </div>
            </div>
        </div>

        <div class="col-md-4">
            <div class="card bg-dark border-secondary text-white text-center shadow-sm">
                <div class="card-body">
                    <h5 class="card-title">Horas de uso (hoy)</h5>
                    <asp:Label ID="lblHorasHoy" runat="server" CssClass="display-6 fw-bold" />
                </div>
            </div>
        </div>

        <div class="col-md-4">
            <div class="card bg-dark border-secondary text-white text-center shadow-sm">
                <div class="card-body">
                    <h5 class="card-title">Apps ejecutadas (hoy)</h5>
                    <asp:Label ID="lblAppsHoy" runat="server" CssClass="display-6 fw-bold" />
                </div>
            </div>
        </div>
    </div>

    <!-- ===== GRÁFICO BARRAS ===== -->
    <div class="card bg-dark border-secondary mb-4 shadow-sm">
        <div class="card-header text-white">Horas de uso por dispositivo (últimos 7 días)</div>
        <div class="card-body">
            <canvas id="chartHoras" height="140"></canvas>
        </div>
    </div>

    <!-- ===== TABLA DETALLADA ===== -->
    <asp:GridView ID="gvMetricas" runat="server"
                  AutoGenerateColumns="False"
                  CssClass="table table-dark table-striped border-secondary"
                  DataKeyNames="Id"
                  GridLines="None">
        <Columns>
            <asp:BoundField DataField="Nombre"            HeaderText="Dispositivo" />
            <asp:BoundField DataField="TiempoActivoHoras" HeaderText="Horas totales"  DataFormatString="{0:N1}" />
            <asp:BoundField DataField="AppsEjecutadas"    HeaderText="Apps ejecutadas" />
            <asp:BoundField DataField="UltimaConexion"    HeaderText="Última conexión" DataFormatString="{0:dd/MM/yyyy HH:mm}" />
        </Columns>
    </asp:GridView>

    <!-- Librería externa -->
    <script src="https://cdn.jsdelivr.net/npm/chart.js@4.4.1/dist/chart.umd.min.js"></script>
</asp:Content>
