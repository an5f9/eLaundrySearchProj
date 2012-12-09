using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace eLaundrySearchWeb
{
    public partial class CustomerRegistration : System.Web.UI.Page
    {
        protected void Page_Load(object sender, EventArgs e)
        {

        }

        protected void btnRegister_Click(object sender, EventArgs e)
        {
            Session["name"] = txtName.Text;
            Session["email"] = txtEmail.Text;
            Session["userId"] = txtUserId.Text;
            Session["password"] = txtEmail.Text;
            Session["mobilenumber"] = txtMobileNo.Text;
            Session["street"] = txtStreet.Text;
            Session["apartment"] = txtApartment.Text;
            Session["city"] = txtCity.Text;
            Session["state"] = txtState.Text;
            Session["country"] = txtCountry.Text;
            Session["zipcode"] = txtZipcode.Text;

            Response.Redirect("ConfirmDetailsCustomer.aspx");
        }

    }
}