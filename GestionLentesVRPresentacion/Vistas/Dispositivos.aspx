<%@ Page Title="Dispositivos" Language="C#" MasterPageFile="~/Site.Master" AutoEventWireup="true" CodeBehind="Dispositivos.aspx.cs" Inherits="FrontVR.Vistas.Dispositivos" %>

<asp:Content ID="Content1" ContentPlaceHolderID="MainContent" runat="server">
    <div class="d-flex justify-content-between align-items-center mb-4">
        <h2 class="text-light">Dispositivos</h2>
    <asp:LinkButton ID="btnAgregar" runat="server" CssClass="btn btn-success" ToolTip="Agregar nuevo dispositivo">
        <i class="fas fa-plus"></i> Agregar dispositivo
    </asp:LinkButton>    </div>

    <div class="table-responsive rounded shadow-sm">
        <asp:GridView ID="gvDispositivos" runat="server" AutoGenerateColumns="False" CssClass="table table-dark table-hover text-light" GridLines="None">
            <Columns>
                <asp:BoundField DataField="Codigo" HeaderText="Dispositivo" />
                <asp:BoundField DataField="Estado" HeaderText="Estado" />
                <asp:BoundField DataField="Ubicacion" HeaderText="Ubicación" />
                <asp:BoundField DataField="Usuario" HeaderText="Usuario" />
                <asp:BoundField DataField="UltimaConexion" HeaderText="Última conexión" />
            </Columns>
        </asp:GridView>
    </div>
</asp:Content>
