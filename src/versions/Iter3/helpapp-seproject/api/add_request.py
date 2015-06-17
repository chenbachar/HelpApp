import webapp2
import json
from models.request import Request

class addRequestHandler(webapp2.RequestHandler):
	def get(self):
		new_req = None
		new_req_description = self.request.get('description')
		new_req_city = self.request.get('city')
		new_req_phone = self.request.get('phone')
		new_req_car = self.request.get('car')
		needCar = False
		if new_req_car == 'true':
			needCar = True
		if new_req_description:
			new_req = Request.add(new_req_city,new_req_phone,new_req_description,needCar)        
			self.response.write(json.dumps({'status':'ok'}))
		else:
			self.response.write(json.dumps({'status':'error'}))
app = webapp2.WSGIApplication([
	('/add_request', addRequestHandler)
], debug=True)

