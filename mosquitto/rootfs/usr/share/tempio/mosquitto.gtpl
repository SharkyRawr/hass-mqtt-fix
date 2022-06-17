protocol mqtt
user root
log_dest stdout
log_type error
log_type warning
log_type notice
log_type information
persistence true
persistence_location /data/

{{ if .anonymous }}
allow_anonymous true
{{ else }}
allow_anonymous false
{{ end }}

{{ if .customize }}
include_dir /share/{{ .customize_folder }}
{{ end }}

listener 1883
protocol mqtt

#listener 1884
#protocol websockets

{{ if .ssl }}

# Follow SSL listener if a certificate exists
listener 8883
protocol mqtt
{{ if .cafile }}
cafile {{ .cafile }}
{{ else }}
cafile {{ .certfile }}
{{ end }}
certfile {{ .certfile }}
keyfile {{ .keyfile }}
require_certificate {{ .require_certificate }}

#listener 8884
#protocol websockets
#{{ if .cafile }}
#cafile {{ .cafile }}
#{{ else }}
#cafile {{ .certfile }}
#{{ end }}
#certfile {{ .certfile }}
#keyfile {{ .keyfile }}
#require_certificate {{ .require_certificate }}

{{ end }}
