using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;
using System.Text;
using System.Security.Cryptography;

namespace eLaundrySearchWeb
{
    public partial class ConfirmDetailsProvider : System.Web.UI.Page
    {
        protected void Page_Load(object sender, EventArgs e)
        {
            lblName.Text = Session["name"].ToString();
            lblUserId.Text = Session["userId"].ToString();
            lblEmail.Text = Session["email"].ToString();
            lblMobile.Text = Session["mobilenumber"].ToString();
            lblLandline.Text = Session["landline"].ToString();
            lblStreet.Text = Session["street"].ToString();
            lblApartment.Text = Session["apartment"].ToString();
            lblCity.Text = Session["city"].ToString();
            lblState.Text = Session["state"].ToString();
            lblServices.Text = Session["services"].ToString();
            lblCountry.Text = Session["country"].ToString();
            lblzipcode.Text = Session["zipcode"].ToString();
            lblYearestablished.Text = Session["yearestablished"].ToString();
            lblDoordelivery.Text = Session["doordelivery"].ToString();
            lblPickup.Text = Session["pickup"].ToString();
        }
        protected void btnRegister_Click(object sender, EventArgs e)
        {
            eLaundrySearchWeb.RegistrationWSRef.RegistrationService registrationServRef
                 = new eLaundrySearchWeb.RegistrationWSRef.RegistrationService();
            eLaundrySearchWeb.RegistrationWSRef.Provider
                provider = new eLaundrySearchWeb.RegistrationWSRef.Provider();
            provider.Name = Session["name"].ToString();
            provider.Email = Session["email"].ToString();
            provider.UserId = Session["userId"].ToString();
            //provider.Password = EncodePasswordToBase64(Session["password"].ToString());
            provider.Password = Session["password"].ToString();
            provider.Mobilenumber = Session["mobilenumber"].ToString();
            provider.Landline = Session["landline"].ToString();
            provider.YearEstablished = Session["yearestablished"].ToString();
            if (Session["doordelivery"].ToString() == "Yes")
            {
                provider.DoorDelivery = true;
            }
            else
            {
                provider.DoorDelivery = true;
            }
            if (Session["pickup"].ToString().Equals("Yes"))
            {
                provider.Pickup = true;
            }
            else
            {
                provider.Pickup = true;
            }

            provider.Services = Session["services"].ToString();
            eLaundrySearchWeb.RegistrationWSRef.Address address =
                new eLaundrySearchWeb.RegistrationWSRef.Address();
            address.Street = Session["street"].ToString();
            address.Apartment = Session["apartment"].ToString();
            address.City = Session["city"].ToString();
            address.State = Session["state"].ToString();
            address.Country = Session["country"].ToString();
            address.Zipcode = Int32.Parse(Session["zipcode"].ToString());
            provider.Address = address;
            string result = registrationServRef.RegisterProvider(provider);
            if (result != null && result.Equals("success"))
            {
                lblMessage.Text = "Registration successfull !!! :)";
            }

        }

        protected void btnEdit_Click(object sender, EventArgs e)
        {
            Response.Redirect("ProviderRegistration.aspx");
        }
        protected static string EncodePasswordToBase64(string password)
        {
            byte[] bytes = Encoding.Unicode.GetBytes(password);
            byte[] inArray = HashAlgorithm.Create("SHA1").ComputeHash(bytes);
            return Convert.ToBase64String(inArray);
        }
    }
}