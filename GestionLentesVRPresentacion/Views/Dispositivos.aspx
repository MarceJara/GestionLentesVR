<%@ Page Title="Dispositivos" Language="C#" MasterPageFile="~/Site.Master" AutoEventWireup="true" CodeBehind="Dispositivos.aspx.cs" Inherits="FrontVR.Dispositivos" %>
<asp:Content ID="Content1" ContentPlaceHolderID="MainContent" runat="server">
    <h2>Gestión de Dispositivos VR</h2>
    <p>Aquí podrás visualizar, editar y monitorear todos los dispositivos conectados al sistema.</p>
    <asp:GridView ID="gvDispositivos" runat="server" CssClass="table table-dark" AutoGenerateColumns="False">
        <Columns>
            <asp:BoundField DataField="Nombre" HeaderText="Nombre del dispositivo" />
            <asp:BoundField DataField="Estado" HeaderText="Estado" />
            <asp:BoundField DataField="Bateria" HeaderText="Batería (%)" />
        </Columns>
    </asp:GridView>
</asp:Content>