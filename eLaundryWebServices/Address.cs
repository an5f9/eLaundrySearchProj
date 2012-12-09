using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace ProviderRegistration
{
    public class Address
    {
        private string street;
        private string apt;
        private string city;
        private string state;
        private string country;
        private int zipcode;

        public string Street
        {
            get { return street; }
            set { this.street= value; }
        }
        public string Apartment
        {
            get { return apt; }
            set { this.apt = value; }

        }
        public string City
        {
            get { return city; }
            set { this.city= value; }
        }
         public string State
        {
            get { return state; }
            set { this.state= value; }
        }
         public string Country
        {
            get { return country; }
            set { this.country= value; }
        }
         public int Zipcode
         {
             get { return zipcode; }
             set { this.zipcode= value; }
         }
    }
    }
