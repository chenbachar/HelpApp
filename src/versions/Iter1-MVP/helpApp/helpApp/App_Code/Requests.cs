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

        public Requests(string requests, int phone)
        {
            this.requests = requests;
            this.phone = phone;
        }
    }
}