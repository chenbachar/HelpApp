import webapp2
import json
from models.user import User

class setCityHandler(webapp2.RequestHandler):
	def get(self):
		user = User.checkUser()
		if not user:
			return
		
		city = self.request.get('city')
		city = int(city)
		
		if city:
			update = User.setCity(user.email,city)        
			self.response.write(json.dumps({'status':'ok'}))
		else:
			self.response.write(json.dumps({'status':'error'}))
			
app = webapp2.WSGIApplication([
	('/setCity', setCityHandler)
], debug=True)