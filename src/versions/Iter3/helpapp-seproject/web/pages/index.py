from google.appengine.ext.webapp import template
import webapp2

class IndexHandler(webapp2.RequestHandler):
	def get(self):
		template_params = {}		
		html = template.render("web/templates/index.html", template_params)
		self.response.write(html)

app = webapp2.WSGIApplication([
	('/', IndexHandler),
	('/index', IndexHandler)
], debug=True)

