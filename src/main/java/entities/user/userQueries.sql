####################################################
####               USER QUERIES                 ####
####################################################
# Insert person
INSERT INTO user (uFirstName, uLastName, uPassport, uEmail, uPhone, uPassword, uUserType)
VALUES (?,?,?,?,?,?,?);

# Query person for login and password authentication
SELECT *
FROM user
WHERE uEmail = ? AND uPassword = ?;

# logic for login
# if (email.equals(uEmail) && password.equals(uPassword)) {
#   Get USER_ID and USER_TYPE
#   Go to partner or customer panel
# } else {
#   popup wrong password try again
# }
