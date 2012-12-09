using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using NUnit.Framework;

namespace ElaundrySearchNUnit
{
    [TestFixture]
    public class LoginNUnit
    {

        [Test]
        public void testValidLogin()
        {
            loginService.LoginService loginService
                = new loginService.LoginService();
            Boolean result = loginService.validateCustomerLogin("test5", "test5");

            Assert.AreEqual(true, result);
        }

        [Test]
        public void testInvalidLogin()
        {
            loginService.LoginService loginService
                = new loginService.LoginService();
            Boolean result = loginService.validateCustomerLogin("invalid", "invalid");

            Assert.AreEqual(false, result);
        }
    }
}
