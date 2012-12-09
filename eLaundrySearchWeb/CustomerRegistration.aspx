<%@ Page Title="" Language="C#" MasterPageFile="~/masterPage.Master" AutoEventWireup="true" CodeBehind="CustomerRegistration.aspx.cs" Inherits="eLaundrySearchWeb.CustomerRegistration" %>
<asp:Content ID="Content1" ContentPlaceHolderID="head" runat="server">
</asp:Content>
<asp:Content ID="Content2" ContentPlaceHolderID="MainContent" runat="server">
<div>
    <table id="registrationTable" align="left" style="margin-left:50px;border-spacing:0.8em;">
    <tr>
        <br />
            <td colspan="2" >
                <span class="formHeader">Customer Registration</span>
            </td>
        </tr>
    <tr>
    <td>
    Name:<asp:RequiredFieldValidator ID="Namevalidator" runat="server" 
                    ErrorMessage="*" ControlToValidate="txtName"></asp:RequiredFieldValidator>
    </td>
    <td><asp:TextBox ID="txtName" runat="server"></asp:TextBox></td>
    </tr>
    <tr>
            <td>Email:<asp:RequiredFieldValidator ID="RequiredFieldValidator2" runat="server" 
                    ErrorMessage="*" ControlToValidate="txtEmail"></asp:RequiredFieldValidator>
                <asp:RegularExpressionValidator ID="RegularExpressionValidator1" runat="server" 
                    ErrorMessage="Invalid format" 
                    ValidationExpression="\w+([-+.']\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*" 
                    ControlToValidate="txtEmail"></asp:RegularExpressionValidator>
            </td>
            <td><asp:TextBox ID="txtEmail" runat="server"></asp:TextBox></td>
         </tr>
         <tr>
            <td>User Id:</td>
            <td><asp:TextBox ID="txtUserId" runat="server"></asp:TextBox></td>
         </tr>
         <tr>
            <td>Password:</td>
            <td><asp:TextBox ID="txtPasswd" runat="server" TextMode="Password"></asp:TextBox></td>
         </tr>
         <tr>
            <td>Re Enter Password:</td>
            <td><asp:TextBox ID="txtRePasswd" runat="server" TextMode="Password"></asp:TextBox></td>
         </tr>
    
         <tr>
            <td>Mobile Number:<asp:RequiredFieldValidator ID="RequiredFieldValidator3" 
                    runat="server" ErrorMessage="*" ControlToValidate="txtMobileNo"></asp:RequiredFieldValidator>
            </td>
            <td><asp:TextBox ID="txtMobileNo" runat="server"></asp:TextBox></td>
         </tr>
         <tr>
            <td>Street:<asp:RequiredFieldValidator ID="RequiredFieldValidator4" runat="server" 
                    ErrorMessage="*" ControlToValidate="txtStreet"></asp:RequiredFieldValidator>
             </td>
            <td><asp:TextBox ID="txtStreet" runat="server"></asp:TextBox></td>
         </tr>
          <tr>
            <td>Apartment:<asp:RequiredFieldValidator ID="RequiredFieldValidator5" 
                    runat="server" ErrorMessage="*" ControlToValidate="txtApartment"></asp:RequiredFieldValidator>
              </td>
            <td><asp:TextBox ID="txtApartment" runat="server"></asp:TextBox></td>
         </tr>
         <tr>
            <td>City:<asp:RequiredFieldValidator ID="RequiredFieldValidator6" runat="server" 
                    ErrorMessage="*" ControlToValidate="txtCity"></asp:RequiredFieldValidator>
             </td>
            <td><asp:TextBox ID="txtCity" runat="server"></asp:TextBox></td>
         </tr>
          <tr>
            <td>State:<asp:RequiredFieldValidator ID="RequiredFieldValidator7" runat="server" 
                    ErrorMessage="*" ControlToValidate="txtState"></asp:RequiredFieldValidator>
              </td>
            <td><asp:TextBox ID="txtState" runat="server"></asp:TextBox></td>
         </tr>
          <tr>
            <td>Country:<asp:RequiredFieldValidator ID="RequiredFieldValidator8" runat="server" 
                    ErrorMessage="*" ControlToValidate="txtCountry"></asp:RequiredFieldValidator>
              </td>
            <td><asp:TextBox ID="txtCountry" runat="server"></asp:TextBox></td>
         </tr>
          <tr>
            <td>Zipcode:<asp:RequiredFieldValidator ID="RequiredFieldValidator9" runat="server" 
                    ErrorMessage="*" ControlToValidate="txtZipcode"></asp:RequiredFieldValidator>
                <asp:RegularExpressionValidator ID="RegularExpressionValidator3" runat="server" 
                    ErrorMessage="Error" ValidationExpression="\d{5}(-\d{4})?" 
                    ControlToValidate="txtZipcode"></asp:RegularExpressionValidator>
              </td>
            <td><asp:TextBox ID="txtZipcode" runat="server"></asp:TextBox></td>
         </tr>
         <tr><td>
            <br />
            <asp:Button ID="btnRegister" runat="server" Text="Register" 
                onclick="btnRegister_Click" />
            </td>
            </tr>

    </table>
    </div>
</asp:Content>
<asp:Content ID="Content3" ContentPlaceHolderID="rightContent" runat="server">
<table width="100%" style="background-image:url('images/table-backgr.jpg'); background-repeat:repeat-y; 
                  border-spacing:1.0em;">
<tr>
    <td><span class="formHeader">Already have an account ?</span></td>
</tr>
<tr>
    <td><img src="/images/login.png"></img></td>
</tr>
<tr>
    <td><img src="/images/fbLogin.png"></img></td>
</tr>
<tr >
    <td><img src="/images/flashholder5.jpg" style="visibility:hidden"></img></td>
</tr>
<tr >
    <td><img src="/images/flashholder5.jpg" style="visibility:hidden"></img></td>
</tr>
</table>
</asp:Content>
