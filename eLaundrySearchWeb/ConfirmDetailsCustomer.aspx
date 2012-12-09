<%@ Page Title="" Language="C#" MasterPageFile="~/masterPage.Master" AutoEventWireup="true"
    CodeBehind="ConfirmDetailsCustomer.aspx.cs" Inherits="eLaundrySearchWeb.ConfDetailsCustomer" %>

<asp:Content ID="Content1" ContentPlaceHolderID="head" runat="server">
</asp:Content>
<asp:Content ID="Content2" ContentPlaceHolderID="MainContent" runat="server">
    <asp:Label ID="lblMessage" runat="server" Text="Label"></asp:Label>
    <br />
    <table id="registrationTable" align="left" style="margin-left: 50px; border-spacing: 0.8em;">
        <tr>
            <td>
                Name:
            </td>
            <td>
                <asp:Label ID="lblName" runat="server" Text=""></asp:Label>
            </td>
        </tr>
        <tr>
            <td>
                Email:
            </td>
            <td>
                <asp:Label ID="lblEmail" runat="server"></asp:Label>
            </td>
        </tr>
        <tr>
            <td>
                User Id:
            </td>
            <td>
                <asp:Label ID="lbluserId" runat="server"></asp:Label>
            </td>
        </tr>
        <tr>
            <td>
                Mobilenumber:
            </td>
            <td>
                <asp:Label ID="lblMobile" runat="server" Text=""></asp:Label>
            </td>
        </tr>
        <tr>
            <td>
                Street:
            </td>
            <td>
                <asp:Label ID="lblStreet" runat="server" Text=""></asp:Label>
            </td>
        </tr>
        <tr>
            <td>
                Apartment:
            </td>
            <td>
                <asp:Label ID="lblApartment" runat="server" Text=""></asp:Label>
            </td>
        </tr>
        <tr>
            <td>
                City:
            </td>
            <td>
                <asp:Label ID="lblCity" runat="server" Text=""></asp:Label>
            </td>
        </tr>
        <tr>
            <td>
                State:
            </td>
            <td>
                <asp:Label ID="lblState" runat="server" Text=""></asp:Label>
            </td>
        </tr>
        <tr>
            <td>
                Country:
            </td>
            <td>
                <asp:Label ID="lblCountry" runat="server" Text=""></asp:Label>
            </td>
        </tr>
        <tr>
            <td>
                Zipcode:
            </td>
            <td>
                <asp:Label ID="lblzipcode" runat="server" Text=""></asp:Label>
            </td>
        </tr>
        <tr>
            <td>
                <asp:Button ID="btnRegister" runat="server" Text="Confirm and Register" OnClick="btnRegister_Click" />
            </td>
            <td>
                <asp:Button ID="btnEdit" runat="server" Text="Edit" OnClick="btnEdit_Click" />
            </td>
        </tr>
    </table>
</asp:Content>
<asp:Content ID="Content3" ContentPlaceHolderID="rightContent" runat="server">
</asp:Content>
