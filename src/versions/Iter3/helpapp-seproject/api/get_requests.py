import webapp2
import json
from models.user import User
from models.request import Request

class addRequestHandler(webapp2.RequestHandler):
	def get(self):
        user = None
        if self.request.cookies.get('our_token'):    #the cookie that should contain the access token!
            user = User.checkToken(self.request.cookies.get('our_token'))

        if not user:
            self.error(403)
            self.response.write('No user - access denied')
            return

        groups = Group.getAllGroups(user)
        self.response.write(json.dumps({"status": "OK", "groups": groups}))

app = webapp2.WSGIApplication([
	('/api/add_request', addRequestHandler)
], debug=True)