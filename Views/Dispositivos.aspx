<%@ Page Title="Dispositivos" Language="C#" MasterPageFile="~/Site.Master" AutoEventWireup="true" CodeBehind="Dispositivos.aspx.cs" Inherits="FrontVR.Views.Dispositivos" %>

<asp:Content ID="Content1" ContentPlaceHolderID="head" runat="server">
</asp:Content>

<asp:Content ID="Content2" ContentPlaceHolderID="MainContent" runat="server">
    <div class="d-flex justify-content-between align-items-center mb-4">
        <h2 class="text-light">Dispositivos</h2>
        <asp:Button ID="btnAgregarDispositivo" runat="server" Text="+ Agregar dispositivo" CssClass="btn btn-outline-light" />
    </div>

    <asp:GridView ID="gvDispositivos" runat="server" AutoGenerateColumns="False" CssClass="table table-dark table-hover rounded shadow-sm" GridLines="None">
        <Columns>
            <asp:BoundField DataField="Codigo" HeaderText="Dispositivo" />
            <asp:BoundField DataField="Estado" HeaderText="Estado" />
            <asp:BoundField DataField="Ubicacion" HeaderText="Ubicación" />
            <asp:BoundField DataField="Usuario" HeaderText="Usuario" /> 
            <asp:BoundField DataField="UltimaConexion" HeaderText="Última conexión" />
        </Columns>
    </asp:GridView>
</asp:Content>
