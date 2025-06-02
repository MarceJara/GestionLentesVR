<%@ Page Title="Aplicaciones" Language="C#" MasterPageFile="~/Site.Master" AutoEventWireup="true" CodeBehind="Aplicaciones.aspx.cs" Inherits="FrontVR.Aplicaciones" %>
<asp:Content ID="Content1" ContentPlaceHolderID="MainContent" runat="server">
    <h2>Aplicaciones Instaladas</h2>
    <p>Consulta qué aplicaciones están en uso y en qué dispositivos están instaladas.</p>
    <asp:GridView ID="gvApps" runat="server" CssClass="table table-dark" AutoGenerateColumns="False">
        <Columns>
            <asp:BoundField DataField="Aplicacion" HeaderText="Aplicación" />
            <asp:BoundField DataField="Version" HeaderText="Versión" />
            <asp:BoundField DataField="DispositivosUsando" HeaderText="En uso por" />
        </Columns>
    </asp:GridView>
</asp:Content>