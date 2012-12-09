using System.Web.Services;
using System.Data.SqlClient;
using ProviderRegistration;
using System.Configuration;

namespace eLaundryWebServices
{
    /// <summary>
    /// Summary description for RegistrationService
    /// </summary>
    [WebService(Namespace = "http://tempuri.org/")]
    [WebServiceBinding(ConformsTo = WsiProfiles.BasicProfile1_1)]
    [System.ComponentModel.ToolboxItem(false)]
    // To allow this Web Service to be called from script, using ASP.NET AJAX, uncomment the following line. 
    // [System.Web.Script.Services.ScriptService]
    public class RegistrationService : System.Web.Services.WebService
    {

        [WebMethod]
        public string RegisterProvider(Provider provider)
        {

            //Declare Connection by passing the connection string from the web config file
            SqlConnection conn = new SqlConnection(ConfigurationManager.ConnectionStrings["dbString"].ConnectionString);
            //Open the connection
            conn.Open();
            int doorDelivery = provider.DoorDelivery ? 1 : 0;
            int pickUp = provider.Pickup ? 1 : 0;
            //Declare the sql command
            
            SqlCommand cmd = new SqlCommand("Insert Into Laundry_Provider (name, phone_num, email, user_id, cell_num, ad_street, ad_apartment ,ad_city ,ad_state, ad_country, ad_zipcode, established_year,laundry_services, "
                   + "door_delivery, pickup, created_dt) values " +
                "('" + provider.Name + "','" + provider.Landline + "','" + provider.Email +"','"+ provider.UserId +"','" + provider.Mobilenumber + "','" + provider.Address.Street + "','" + provider.Address.Apartment +
                 "','" + provider.Address.City + "','" + provider.Address.State + "','" + provider.Address.Country + "','" + provider.Address.Zipcode + "','" + provider.YearEstablished + "','" + provider.Services +
                  "'," + doorDelivery + "," + pickUp + " , GETDATE() )", conn);
            //Execute the Insert query
            cmd.ExecuteNonQuery();
            cmd.Dispose();

            SqlCommand userInsert = new SqlCommand("Insert Into USER_LOGIN (user_id, user_pass, user_type, last_login) values " +
                "('" + provider.UserId + "','" + provider.Password + "','P', GETDATE() )", conn);
            //Execute the Insert query
            userInsert.ExecuteNonQuery();
            userInsert.Dispose();

            //close the connection
            conn.Close();
            return "success";
        }

        [WebMethod]
        public string RegisterCustomer(Customer customer)
        {

            //Declare Connection by passing the connection string from the web config file
            SqlConnection conn = new SqlConnection(ConfigurationManager.ConnectionStrings["dbString"].ConnectionString);
            //Open the connection
            conn.Open();
            //Declare the sql command

            SqlCommand cmd = new SqlCommand("Insert Into Customer (name,email,mobilenumber, ad_street, ad_apartment ,ad_city ,ad_state, ad_country, ad_zipcode "
                   + "door_delivery, pickup, created_dt) values " +
                "('" + customer.Name + "','" + customer.Email + "','" + customer.Mobilenumber + "','" + customer.Address.Street + "','" + customer.Address.Apartment +
                 "','" + customer.Address.City + "','" + customer.Address.State + "','" + customer.Address.Country + "','" + customer.Address.Zipcode + ")", conn);
            //Execute the Insert query
            cmd.ExecuteNonQuery();
            cmd.Dispose();
            //close the connection
            conn.Close();
            //Display sucess message
            return "success";
        }
    }
}
