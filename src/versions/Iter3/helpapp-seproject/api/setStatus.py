import webapp2
import json
from models.user import User

class setStatusHandler(webapp2.RequestHandler):
	def get(self):
		user = User.checkUser()
		if not user:
			return
		
		stat = self.request.get('stat')
		user_status = False
		if stat == 'true':
			user_status = True
		if stat:
			update = User.setStatus(user.email,user_status)        
			self.response.write(json.dumps({'status':'ok'}))
		else:
			self.response.write(json.dumps({'status':'error'}))
			
app = webapp2.WSGIApplication([
	('/setStatus', setStatusHandler)
], debug=True)