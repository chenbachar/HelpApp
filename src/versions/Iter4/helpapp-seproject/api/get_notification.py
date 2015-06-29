import webapp2
import json
from models.user import User
from models.request import Request
class getNotificationHandler(webapp2.RequestHandler):
	def get(self):
		googleUser = self.request.get('user')
		
		if googleUser == "None":
			self.response.write('You are not connected')
			return
		
		user = User.query(User.email == googleUser).get()
		
		if not user:
			self.response.write('No user in db')
			return
			
		if user.status == False:
			self.response.write(json.dumps({'status':'False'}))
			return
		
		if user.status == True: 
			cit = Request.checkCity(user.city)
			if cit == False:
				self.response.write(json.dumps({'status':'False'}))
				return
			if cit == True:
				self.response.write(json.dumps({'status':'True'}))
				return
		self.response.write(json.dumps({'status':'False'}))
		
app = webapp2.WSGIApplication([
	('/get_notification', getNotificationHandler)
], debug=True)