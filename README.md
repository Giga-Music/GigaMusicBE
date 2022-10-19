# GigaMusicBE

## Admin
### Play list:
#### CRUD + list sorted by rating or name(?sort=name:asc) + search by name + login (username/password : return JWT)
- id : String
- name : String
- image : String
- description : String
- ratings : List of Integer (from 0 to 5) - return avarage

### Music:
#### CRUD + search by name + filter by Play list
- id : String
- name : String
- image : String
- description : String
- file : String - (validation: file in format: .mp3) - return only on edit and get by id
- Play list (foreign key)(many to many) : List of Strings


## User
### Play list:
#### Add rating to the PL

### Music:
#### Get random track (by Play list) (with limit) params: (?limit=5 ?playlist=id)

# [Design](https://whimsical.com/gigamusic-Dk7K5FKSoExK22H8Petw5Z)
