<%@ Page Title="Administración" Language="C#" MasterPageFile="~/Site.Master" AutoEventWireup="true" CodeBehind="Administracion.aspx.cs" Inherits="FrontVR.Administracion" %>
<asp:Content ID="Content1" ContentPlaceHolderID="MainContent" runat="server">
    <h2>Panel de Administración</h2>
    <p>Accede a funciones avanzadas como gestión de usuarios, roles y seguridad del sistema.</p>
    <asp:Button ID="btnUsuarios" runat="server" Text="Ver usuarios" CssClass="btn btn-secondary" />
</asp:Content>