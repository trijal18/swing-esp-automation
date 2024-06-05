from flask import Flask, request, jsonify

app = Flask(__name__)

# Define a variable to store received data globally
received_data = None

@app.route('/', methods=['GET', 'POST'])
def handle_requests():
    global received_data  # Access the global variable

    if request.method == 'GET':
        # Display received data from POST request, if any
        if received_data:
            return f"Received data: {received_data}"
        else:
            return "No data received yet."
    elif request.method == 'POST':
        data = request.json
        received_data = data  # Store received data globally
        return jsonify({"received_data": data})

if __name__ == '__main__':
    app.run(debug=True)
