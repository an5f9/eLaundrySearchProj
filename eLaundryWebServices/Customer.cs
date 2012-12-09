using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace ProviderRegistration
{
    public class Customer
    {
        private string name;
        private string email;
        private string mobilenumber;
        private Address address;
        public string Name
        {
            get { return name; }
            set { this.name = value; }
        }
        public string Email
        {
            get { return email; }
            set { this.email = value; }
        }
        public string Mobilenumber
        {
            get { return mobilenumber; }
            set { this.mobilenumber = value; }
        }
        public Address Address
        {
            get { return address; }
            set { this.address = value; }
        }
    }
}