<%@ Page Language="C#"
         MasterPageFile="~/Site.Master"
         AutoEventWireup="true"
         CodeBehind="Aplicaciones.aspx.cs"
         Inherits="FrontVR.Vistas.Aplicaciones" %>

<asp:Content ID="Main" ContentPlaceHolderID="MainContent" runat="server">

    <h2 class="page-title mb-3">Aplicaciones disponibles</h2>

    <!-- Botón alta de nuevas apps -->
<button type="button"
        class="btn btn-primary mb-3"
        data-bs-toggle="modal"
        data-bs-target="#modalNuevaApp">
    <i class="fa fa-plus"></i> Nueva aplicación
</button>


    <!-- Tabla principal -->
    <asp:GridView ID="gvAplicaciones" runat="server"
        AutoGenerateColumns="False" CssClass="table table-striped"
        DataKeyNames="Id"
        OnRowCommand="gvAplicaciones_RowCommand">
        <Columns>
            <asp:BoundField DataField="Nombre" HeaderText="Nombre" />
            <asp:BoundField DataField="Version" HeaderText="Versión" />
            <asp:BoundField DataField="TamanoMb" HeaderText="Tamaño&nbsp;(MB)"
                            DataFormatString="{0:N1}" />
             <%-- Badge de estado --%>
        <asp:TemplateField HeaderText="Estado">
            <ItemTemplate>
                <asp:Label ID="lblEstado" runat="server"
                           Text='<%# Eval("Estado") %>'
                           CssClass='<%# GetBadgeCss(Eval("Estado")) %>' />
            </ItemTemplate>
        </asp:TemplateField>

        <%-- Acción dinámica instalar / desinstalar --%>
        <asp:TemplateField HeaderText="Acción" ItemStyle-HorizontalAlign="Center">
            <ItemTemplate>
                <asp:LinkButton ID="lnkAccion" runat="server"
                    CommandName="ToggleInstall"
                    CommandArgument='<%# Eval("Id") %>'
                    Text='<%# (Eval("Estado").ToString() == "Instalada") ? "Desinstalar" : "Instalar" %>'
                    CssClass='<%# (Eval("Estado").ToString() == "Instalada") ?
                               "btn btn-danger btn-sm" : "btn btn-success btn-sm" %>' />
            </ItemTemplate>
            </asp:TemplateField>
        </Columns>
    </asp:GridView>
     
<!-- ===== Modal NUEVA APLICACIÓN – DARK ===== -->
<div class="modal fade" id="modalNuevaApp" tabindex="-1"
     aria-labelledby="modalNuevaAppLabel" aria-hidden="true"
     data-bs-theme="dark">            <%-- ❶ Activa tema oscuro solo en el modal --%>
  <div class="modal-dialog">
    <div class="modal-content bg-dark text-white">   <%-- ❷ Fondo oscuro + texto claro --%>

      <div class="modal-header border-secondary">
        <h5 class="modal-title" id="modalNuevaAppLabel">Nueva aplicación</h5>
        <button type="button" class="btn-close btn-close-white"   <%-- ❸ Ícono blanco --%>
                data-bs-dismiss="modal" aria-label="Cerrar"></button>
      </div>

      <asp:UpdatePanel ID="upModal" runat="server">
        <ContentTemplate>
          <div class="modal-body">

            <div class="mb-3">
              <label for="txtNombre" class="form-label">Nombre</label>
              <asp:TextBox ID="txtNombre" runat="server"
                           CssClass="form-control bg-dark text-white border-secondary" />
            </div>

            <div class="mb-3">
              <label for="txtVersion" class="form-label">Versión</label>
              <asp:TextBox ID="txtVersion" runat="server"
                           CssClass="form-control bg-dark text-white border-secondary" />
            </div>

            <div class="mb-3">
              <label for="txtTamano" class="form-label">Tamaño&nbsp;(MB)</label>
              <asp:TextBox ID="txtTamano" runat="server" TextMode="Number"
                           CssClass="form-control bg-dark text-white border-secondary" />
            </div>

            <asp:Label ID="lblError" runat="server"
                       CssClass="text-danger" Visible="false" />
          </div>

          <div class="modal-footer border-secondary">
            <button type="button" class="btn btn-outline-light"
                    data-bs-dismiss="modal">Cancelar</button>

            <asp:Button ID="btnGuardar" runat="server" Text="Guardar"
                        CssClass="btn btn-primary" OnClick="btnGuardar_Click" />
          </div>
        </ContentTemplate>
      </asp:UpdatePanel>

    </div>
  </div>
</div>




</asp:Content>
