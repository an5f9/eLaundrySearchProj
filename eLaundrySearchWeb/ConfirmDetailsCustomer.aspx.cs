using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace eLaundrySearchWeb
{
    public partial class ConfDetailsCustomer : System.Web.UI.Page
    {
        protected void Page_Load(object sender, EventArgs e)
        {
            lblName.Text = Session["name"].ToString();
            lblEmail.Text = Session["email"].ToString();
            lbluserId.Text = Session["userId"].ToString();
            lblMobile.Text = Session["mobilenumber"].ToString();
            lblStreet.Text = Session["street"].ToString();
            lblApartment.Text = Session["apartment"].ToString();
            lblCity.Text = Session["city"].ToString();
            lblState.Text = Session["state"].ToString();
            lblCountry.Text = Session["country"].ToString();
            lblzipcode.Text = Session["zipcode"].ToString();
        }

        protected void btnRegister_Click(object sender, EventArgs e)
        {
            eLaundrySearchWeb.RegistrationWSRef.RegistrationService
                service = new eLaundrySearchWeb.RegistrationWSRef.RegistrationService();
            eLaundrySearchWeb.RegistrationWSRef.Customer provider
                = new eLaundrySearchWeb.RegistrationWSRef.Customer(); ;
            provider.Name = Session["name"].ToString();
            provider.Email = Session["email"].ToString();
            provider.Mobilenumber = Session["mobilenumber"].ToString();
        }

        protected void btnEdit_Click(object sender, EventArgs e)
        {
            Response.Redirect("CustomerRegistration.aspx");
        }

    }
}