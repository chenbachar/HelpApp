from google.appengine.ext.webapp import template
import webapp2

class helpSeekerHandler(webapp2.RequestHandler):
	def get(self):
		template_params = {}		
		
		html = template.render("web/templates/helpSeeker.html", template_params)
		self.response.write(html)

app = webapp2.WSGIApplication([
	('/helpSeeker', helpSeekerHandler)
], debug=True)

