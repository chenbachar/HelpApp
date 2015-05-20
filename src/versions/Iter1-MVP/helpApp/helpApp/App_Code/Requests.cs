using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;


namespace helpApp.App_Code
{
    public class Requests
    {
        private string requests;
        private int phone;
        private string name;

        public Requests(string requests, string name, int phone)
        {
            this.requests = requests;
            this.phone = phone;
            this.name = name;
        }

        public string Request
        {
            set { this.requests = value; }
            get { return this.requests; }
        }
        public string Name
        {
            set { this.name = value; }
            get { return this.name; }
        }
        public int Phone
        {
            set { this.phone = value; }
            get { return this.phone; }
        }
    }
}