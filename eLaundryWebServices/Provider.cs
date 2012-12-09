using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Security.Cryptography;
using System.Text;

namespace ProviderRegistration
{
    public class Provider
    {
        private string name;
        private Address address;
        private string mobilenumber;
        private string email;
        private string userId;
        private string password;
        private string landline;
        private string yearEstablished;
        private string services;
        private Boolean doorDelivery;
        private Boolean pickup;
        private DateTime createddate;

        public string Name
        {
            get { return name; }
            set { this.name = value; }
        }

        public Address Address
        {
            get { return address; }
            set { this.address = value; }
        }
         public string Email
        {
            get { return email; }
            set { this.email = value; }
        }
         public string UserId
         {
             get { return userId; }
             set { this.userId = value; }
         }
         public string Password
         {
             get { return password; }
            // set { this.password = EncodePasswordToBase64(value); }
             set { this.password = value; }
         }

          public string Mobilenumber
        {
            get { return mobilenumber; }
            set { this.mobilenumber = value; }
        }
          public string Landline
        {
            get { return landline; }
            set { this.landline= value; }
        }
        public string YearEstablished
        {
            get { return yearEstablished; }
            set { this.yearEstablished = value; }
        }
        public string Services
        {
            get { return services; }
            set { this.services = value; }
        }
        public Boolean DoorDelivery
        {
            get { return doorDelivery; }
            set { this.doorDelivery = value; }
        }
        public Boolean Pickup
        {
            get { return pickup; }
            set { this.pickup = value; }
        }
         public DateTime Createddate
        {
            get { return createddate; }
            set { this.createddate = value; }
        }
         protected static string EncodePasswordToBase64(string password)
         {
             byte[] bytes = Encoding.Unicode.GetBytes(password);
             byte[] inArray = HashAlgorithm.Create("SHA1").ComputeHash(bytes);
             return Convert.ToBase64String(inArray);
         }


    }

}
