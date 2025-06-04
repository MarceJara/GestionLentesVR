<%@ Page Title="Dispositivos" Language="C#" MasterPageFile="~/Site.Master" AutoEventWireup="true" CodeBehind="Dispositivos.aspx.cs" Inherits="FrontVR.Vistas.Dispositivos" %>

<asp:Content ID="Content1" ContentPlaceHolderID="MainContent" runat="server">
    <div class="mb-4">
        <h2 class="text-light">Dispositivos</h2>
    </div>

    <asp:Panel ID="pnlFormulario" runat="server" CssClass="mb-4">
        <asp:Label ID="lblId" runat="server" Text="ID (Solo para editar)" CssClass="form-label text-light" /><br />
        <asp:TextBox ID="txtId" runat="server" CssClass="form-control" /><br />

        <asp:Label ID="lblNombre" runat="server" Text="Nombre" CssClass="form-label text-light" /><br />
        <asp:TextBox ID="txtNombre" runat="server" CssClass="form-control" /><br />

        <asp:Label ID="lblModelo" runat="server" Text="Modelo" CssClass="form-label text-light" /><br />
        <asp:TextBox ID="txtModelo" runat="server" CssClass="form-control" /><br />

        <asp:Label ID="lblSerie" runat="server" Text="Número de Serie" CssClass="form-label text-light" /><br />
        <asp:TextBox ID="txtSerie" runat="server" CssClass="form-control" /><br />

        <asp:Label ID="lblFecha" runat="server" Text="Fecha de Registro" CssClass="form-label text-light" /><br />
        <asp:TextBox ID="txtFecha" runat="server" CssClass="form-control" placeholder="yyyy-MM-dd" /><br />

        <asp:Label ID="lblUbicacion" runat="server" Text="Ubicación" CssClass="form-label text-light" /><br />
        <asp:TextBox ID="txtUbicacion" runat="server" CssClass="form-control" /><br />

        <asp:Button ID="btnGuardar" runat="server" Text="Guardar" CssClass="btn btn-primary mt-2" OnClick="btnGuardar_Click" />
    </asp:Panel>

    <asp:GridView ID="gvDispositivos" runat="server" AutoGenerateColumns="False" CssClass="table table-dark table-hover text-light" GridLines="None" OnRowCommand="gvDispositivos_RowCommand">
        <Columns>
            <asp:BoundField DataField="dispositivoId" HeaderText="ID" />
            <asp:BoundField DataField="nombre" HeaderText="Nombre" />
            <asp:BoundField DataField="modelo" HeaderText="Modelo" />
            <asp:BoundField DataField="numeroSerie" HeaderText="Serie" />
            <asp:BoundField DataField="fechaRegistro" HeaderText="Fecha" DataFormatString="{0:yyyy-MM-dd}" />
            <asp:BoundField DataField="ubicacion" HeaderText="Ubicación" />
            <asp:ButtonField Text="Editar" CommandName="Editar" ButtonType="Button" />
            <asp:ButtonField Text="Eliminar" CommandName="Eliminar" ButtonType="Button" />
        </Columns>
    </asp:GridView>
</asp:Content>
