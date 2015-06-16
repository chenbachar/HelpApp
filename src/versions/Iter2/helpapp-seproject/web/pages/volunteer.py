from google.appengine.ext.webapp import template
import webapp2
from models.user import User

class VolunteerHandler(webapp2.RequestHandler):
	def get(self):
		template_params = {}
		user = User.checkUser()
		
		if user:
			template_params['email'] = user.email
			template_params['name'] = user.name
			template_params['phone'] = user.phone
			template_params['status'] = user.status
			template_params['hasCar'] = user.hasCar
			template_params['logoutUrl'] = user.logoutUrl()
			
		else:
			self.redirect('/')
			return
		
		
		html = template.render("web/templates/volunteer.html", template_params)
		self.response.write(html)

app = webapp2.WSGIApplication([
	('/volunteer', VolunteerHandler)
], debug=True)

