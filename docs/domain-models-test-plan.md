# Domain Models, Class Diagrams and Test Plan

[1. User Stories and Tests](#user-stories-and-tests)

# User Stories and Tests

## 1. As a user I want to be able to add a contact to my address book do that I can use that information to contact them

### Tests
1. ContactManager adds contact to Contact
2. Added contact information is correctly stored in the address book.

---

## 2. As a user I want to be able to search for a contact by name so that I can contact them

### Tests
1. check that a contact can be searched by name.
2. check that the correct contact is returned when searched by name.

---

## 3. As a user I want to be able to see my search results so that I can check I am contacting the right person

### Tests
1. search results are displayed to user.
2. search results contain the correct contact information.

---

## 4. As a user I want to be able to remove a contact from the address book as I am longer friends with them

### Tests
1. Check a contact can be removed from the address book.
2. Check that the removed contact is no longer in the address book.
---

## 5. As a user I want to be able to edit a contacts details as they have changed address

### Tests
1. Check that a contact's details can be edited.
2. Edited details are correctly updated in the address book.
---

## 6. As a user I do not want to have duplicate phone numbers and address so that

### Tests
1. check that the system does not allow duplicate phone numbers for a contact.
2. Check that the system does not allow duplicate addresses for a contact.
---

## 7. As a user I want to be able to view all my contacts in the address book so that I can see how many people I know

### Tests
1. all contacts in the address book can be viewed.
2. correct number of contacts is displayed when viewing all contacts.
---

## 8. As a user I want to have an interface so that it is easier to use my address book

### Tests
1. check that the interface is user-friendly and intuitive.
2. check that all necessary functionalities (add, search, edit, delete contacts) are accessible through the interface.
---

## 9. AF - As a user I want to be able to search for a contact by phone number and have the results displayed so that I can see who’s number keeps calling

### Tests
1. a contact can be searched by phone number.
2. the correct contact is returned when searched by phone number.
---

## 10. AF As a user I want to be able to search for a contact by email address and have the results display so that I can see who is emailing me

### Tests
1. a contact can be searched by email address.
2. the correct contact is returned when searched by email address.
---

## 11. AF As a user I want to be able to search for a contact by name, number, email address and have them displayed in alphabetical order so it is easier to find what I am looking for

### Tests
1.  a contact can be searched by name, number, and email address.
2.  the search results are displayed in alphabetical order.
---

## 12. AF As a user I want to be able to delete all contacts at once and confirm I am doing this so that I can live my life as a hermit but still not accidentally delete everything If I don’t want too

### Tests
1.  all contacts can be deleted at once.
2.  a confirmation prompt is displayed before deleting all contacts.