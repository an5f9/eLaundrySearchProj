<%@ Page Title="" Language="C#" MasterPageFile="~/masterPage.Master" AutoEventWireup="true" CodeBehind="LaundryShopRegistration.aspx.cs" Inherits="eLaundrySearchWeb.LaundryShopRegistration" %>
<asp:Content ID="Content1" ContentPlaceHolderID="head" runat="server">
</asp:Content>
<asp:Content ID="Content2" ContentPlaceHolderID="MainContent" runat="server">
      
      <div>
      <table id="registrationTable" align="left" style="margin-left:50px;border-spacing:0.8em;">
        <tr>
        <br />
            <td colspan="2" >
                <span class="formHeader">Laundry Shop Registration</span>
            </td>
        </tr>
         <tr>
            <td>Name:<asp:RequiredFieldValidator ID="Namevalidator" runat="server" 
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
            <td>Create User Id: </td>
            <td><asp:TextBox ID="txtUserId" runat="server"></asp:TextBox></td>
         </tr>
         <tr>
            <td>Choose Password:
            </td>
            <td><asp:TextBox ID="txtPassword" runat="server" TextMode="Password"></asp:TextBox></td>
            <td><asp:RequiredFieldValidator ID="RequiredFieldValidator14" 
                    runat="server" ErrorMessage="*" ControlToValidate="txtPassword"></asp:RequiredFieldValidator></td>
         </tr>
         <tr>
            <td>Re Enter Password:
            </td>
            <td><asp:TextBox ID="txtRePasswd" runat="server" TextMode="Password"></asp:TextBox></td>
            <td><asp:RequiredFieldValidator ID="RequiredFieldValidator1" 
                    runat="server" ErrorMessage="*" ControlToValidate="txtRePasswd"></asp:RequiredFieldValidator></td>
         </tr>
        <tr>
            <td>Mobile Number:<asp:RequiredFieldValidator ID="RequiredFieldValidator3" 
                    runat="server" ErrorMessage="*" ControlToValidate="txtMobileNo"></asp:RequiredFieldValidator>
            </td>
            <td><asp:TextBox ID="txtMobileNo" runat="server"></asp:TextBox></td>
         </tr>
        <tr>
            <td>Land Line:</td>
            <td><asp:TextBox ID="txtLandLine" runat="server"></asp:TextBox></td>
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
          <tr>
            <td>Year Established<asp:RequiredFieldValidator ID="RequiredFieldValidator10" 
                    runat="server" ErrorMessage="*" ControlToValidate="txtYrestablished"></asp:RequiredFieldValidator>
                <asp:RegularExpressionValidator ID="RegularExpressionValidator4" runat="server" 
                    ErrorMessage="not valid" ValidationExpression="^[0-9]{4}$" 
                    ControlToValidate="txtYrestablished"></asp:RegularExpressionValidator>
              </td>
            <td><asp:TextBox ID="txtYrestablished" runat="server"></asp:TextBox></td>
         </tr>
         <tr>
            <td>services<asp:RequiredFieldValidator ID="RequiredFieldValidator11" 
                    runat="server" ErrorMessage="*" ControlToValidate="txtServices"></asp:RequiredFieldValidator>
             </td>
            <td><asp:TextBox ID="txtServices" runat="server"></asp:TextBox></td>
         </tr>
         <tr>
            <td>Door Delivery<asp:RequiredFieldValidator ID="RequiredFieldValidator12" 
                    runat="server" ErrorMessage="*" ControlToValidate="ddDoordelivery"></asp:RequiredFieldValidator>
             </td>
            <td>
                <asp:DropDownList ID="ddDoordelivery" runat="server">
                    <asp:ListItem>yes</asp:ListItem>
                    <asp:ListItem>no</asp:ListItem>
                </asp:DropDownList>
             </td>
         </tr>
         <tr>
            <td>PickUp<asp:RequiredFieldValidator ID="RequiredFieldValidator13" runat="server" 
                    ErrorMessage="*" ControlToValidate="ddPickup"></asp:RequiredFieldValidator>
             </td>
            <td>
                <asp:DropDownList ID="ddPickup" runat="server">
                    <asp:ListItem>yes</asp:ListItem>
                    <asp:ListItem>no</asp:ListItem>
                </asp:DropDownList>
             </td>
         </tr>
            <tr>
            <td></td>
            <td>
            <br />
            <asp:Button ID="btnRegister" runat="server" Text="Register" 
                onclick="btnRegister_Click" />
            </td>
            </tr>
        </table>
        </div>
</asp:Content>
