using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace eLaundrySearchWeb
{
    public partial class CustomerLogin : System.Web.UI.Page
    {
        protected void Page_Load(object sender, EventArgs e)
        {

        }
        public void customerLogin_Authenticate(object sender, AuthenticateEventArgs e)
        {
            
            e.Authenticated = true;
        }
    }
}