<%@ Page Language="C#" 
        MasterPageFile="~/Site.Master"
        AutoEventWireup="true" 
        CodeBehind="Metricas.aspx.cs" 
        Inherits="FrontVR.Vistas.Metricas" %>

<asp:Content ID="Main" ContentPlaceHolderID="MainContent" runat="server">
    
        <div class="container mt-5">
            <h2 class="mb-4 text-white">Métricas de Uso de Dispositivos</h2>

            <!-- Grid de métricas -->
            <asp:GridView ID="gvMetricas" runat="server"
                          AutoGenerateColumns="False"
                          CssClass="table table-striped table-hover text-white"
                          GridLines="None"
                          EmptyDataText="No se encontraron métricas registradas.">
                <Columns>
                    <asp:BoundField DataField="Nombre" HeaderText="Nombre del dispositivo" />
                    <asp:BoundField DataField="TiempoActivoHorasSemanal" HeaderText="Horas activas (semana)" DataFormatString="{0:N1}" />
                </Columns>
                <EmptyDataTemplate>
                    <div class="alert alert-dark text-center" role="alert">
                        No se encontraron métricas registradas.
                    </div>
                </EmptyDataTemplate>
            </asp:GridView>

            <!-- Gráfico de barras -->
            <div class="mt-5">
                <h4>Visualización gráfica</h4>
                <canvas id="chartHoras" width="800" height="400"></canvas>
            </div>
        </div>
</asp:Content>
