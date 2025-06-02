<%@ Page Title="Aplicaciones" Language="C#" MasterPageFile="~/Site.Master" AutoEventWireup="true" CodeBehind="Aplicaciones.aspx.cs" Inherits="FrontVR.Views.Aplicaciones" %>

<asp:Content ID="Content1" ContentPlaceHolderID="head" runat="server">
</asp:Content>

<asp:Content ID="Content2" ContentPlaceHolderID="MainContent" runat="server">
    <h2 class="text-light mb-4">Aplicaciones</h2>

    <asp:GridView ID="gvAplicaciones" runat="server" AutoGenerateColumns="False" CssClass="table table-dark table-hover rounded shadow-sm text-light" GridLines="None">
        <Columns>
            <asp:BoundField DataField="Nombre" HeaderText="Nombre" />
            <asp:BoundField DataField="Descripcion" HeaderText="Descripción" />
            <asp:BoundField DataField="Usuarios" HeaderText="Usuarios" />
            <asp:BoundField DataField="Estado" HeaderText="Estado" />
            <asp:BoundField DataField="UltimaActualizacion" HeaderText="Última Actualización" />

            <asp:TemplateField HeaderText="Acciones">
                <ItemTemplate>
                    <div class="d-flex gap-2">
                        <asp:LinkButton runat="server" CssClass="btn btn-sm btn-primary" ToolTip="Ver"><i class="fas fa-eye"></i></asp:LinkButton>
                        <asp:LinkButton runat="server" CssClass="btn btn-sm btn-warning text-dark" ToolTip="Editar"><i class="fas fa-edit"></i></asp:LinkButton>
                        <asp:LinkButton runat="server" CssClass="btn btn-sm btn-danger" ToolTip="Eliminar"><i class="fas fa-trash"></i></asp:LinkButton>
                    </div>
                </ItemTemplate>
            </asp:TemplateField>
        </Columns>
    </asp:GridView>
</asp:Content>
