<%@ Page Title="Configuraciones" Language="C#" MasterPageFile="~/Site.Master" AutoEventWireup="true" CodeBehind="Configuraciones.aspx.cs" Inherits="FrontVR.Configuraciones" %>
<asp:Content ID="Content1" ContentPlaceHolderID="MainContent" runat="server">
    <h2>Configuraciones del Sistema</h2>
    <p>Ajusta parámetros generales del sistema y preferencias de notificación.</p>
    <asp:CheckBox ID="chkNotificaciones" runat="server" Text="Activar notificaciones de alerta" />
</asp:Content>