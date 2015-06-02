from google.appengine.ext.webapp import template
import webapp2

class VolunteerHandler(webapp2.RequestHandler):
	def get(self):
		template_params = {}		
		html = template.render("web/templates/volunteer.html", template_params)
		self.response.write(html)

app = webapp2.WSGIApplication([
	('/volunteer', VolunteerHandler)
], debug=True)

