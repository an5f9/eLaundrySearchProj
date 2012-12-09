using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace eLaundrySearchWeb
{
    public partial class LaundryShopRegistration : System.Web.UI.Page
    {
        protected void Page_Load(object sender, EventArgs e)
        {

        }
        protected void btnRegister_Click(object sender, EventArgs e)
        {
            Session["name"] = txtName.Text;
            Session["userId"] = txtUserId.Text;
            Session["password"] = txtPassword.Text;
            Session["rePassword"] = txtRePasswd.Text;
            Session["email"] = txtEmail.Text;
            Session["mobilenumber"] = txtMobileNo.Text;
            Session["landline"] = txtLandLine.Text;
            Session["street"] = txtStreet.Text;
            Session["apartment"] = txtApartment.Text;
            Session["city"] = txtCity.Text;
            Session["state"] = txtState.Text;
            Session["country"] = txtCountry.Text;
            Session["zipcode"] = txtZipcode.Text;
            Session["yearestablished"] = txtYrestablished.Text;
            Session["services"] = txtServices.Text;
            Session["doordelivery"] = ddDoordelivery.SelectedValue;
            Session["pickup"] = ddPickup.SelectedValue;
            Response.Redirect("ConfirmDetailsProvider.aspx");
        }
    }
}