#from google.appengine.api import users
from google.appengine.ext.webapp import template

from models.user import User
import webapp2

class IndexHandler(webapp2.RequestHandler):
	def get(self):
		template_params = {}
		user = User.connect()
		if user==None:
			template_params['loginUrl'] = User.loginUrl()
		else:
			self.redirect('/volunteer')

		html = template.render("web/templates/connect.html", template_params)
		self.response.write(html)
		
		
app = webapp2.WSGIApplication([
	('/connect', IndexHandler)
], debug=True)
