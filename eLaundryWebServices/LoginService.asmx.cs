using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Services;
using System.Data.SqlClient;
using System.Configuration;
using System.Security.Cryptography;
using System.Text;

namespace eLaundryWebServices
{
    /// <summary>
    /// Summary description for LoginService
    /// </summary>
    [WebService(Namespace = "http://tempuri.org/")]
    [WebServiceBinding(ConformsTo = WsiProfiles.BasicProfile1_1)]
    [System.ComponentModel.ToolboxItem(false)]
    // To allow this Web Service to be called from script, using ASP.NET AJAX, uncomment the following line. 
    // [System.Web.Script.Services.ScriptService]
    public class LoginService : System.Web.Services.WebService
    {

        [WebMethod]
        public Boolean validateCustomerLogin(string user, string password)
        {
            Int32 result = 0;
            // try
            //{

            //Declare Connection by passing the connection string from the web config file
            SqlConnection conn = new SqlConnection(ConfigurationManager.ConnectionStrings["dbString"].ConnectionString);
            //Open the connection
            //string passToCompare = EncodePasswordToBase64(password);
            conn.Open();
            //Declare the sql command
            SqlCommand cmd = new SqlCommand("Select count(*) from USER_LOGIN where user_id='" + user + "' AND "
                               + " user_pass= '" + password + "'", conn);
            //use SqlDataReader to read the data from DB 
            
            result = Int32.Parse(cmd.ExecuteScalar().ToString());
            if (result == 1)
            {
                return true;
            }
            cmd.Dispose();
            conn.Close();
            return false;
        }
        [WebMethod]
        public Boolean validateProviderLogin()
        {

            return false;
        }
        protected static string EncodePasswordToBase64(string password)
        {
            byte[] bytes = Encoding.Unicode.GetBytes(password);
            byte[] inArray = HashAlgorithm.Create("SHA1").ComputeHash(bytes);
            return Convert.ToBase64String(inArray);
        }
    }
}
