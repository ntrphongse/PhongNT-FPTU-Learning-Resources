using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;

namespace DammioMVC.Controllers
{
    public class DammioController : Controller
    {
        // GET: /Dammio/
        public ActionResult Index()
        {
            //return "Đây là phương thức Index, phương thức mặc định của Controller Dammio.";
            return View();
        }

        // GET: /Dammio/Hello
        public ActionResult Hello(String name, int numTimes = 1)
        {
            ViewBag.Message = "Hello " + name;
            ViewBag.NumTimes = numTimes;
            return View();
        }
        // GET: /Dammio/ChaoMung/
        public string ChaoMung(string ten, int tuoi = 1)
        {
            return HttpUtility.HtmlEncode("Xin chào " + ten + ". Tuổi của bạn là: " + tuoi);
        }
    }
}