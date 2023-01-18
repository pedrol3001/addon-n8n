#!/usr/bin/with-contenv bashio
# ==============================================================================
# Start the example service
# s6-overlay docs: https://github.com/just-containers/s6-overlay
# ==============================================================================

# Add your code here

# Declare variables

## Get the 'message' key from the user config options.


## Print the message the user supplied, defaults to "Hello World..."


## Run your program
exec n8n start