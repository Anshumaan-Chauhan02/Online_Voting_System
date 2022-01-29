import requests

def check_peer(resp):
    orig_resp = resp.raw._original_response
    if hasattr(orig_resp,'peer'):
        return getattr(orig_resp,'peer')
r1 = requests.get('http://www.google.com')
check_peer(r1)
