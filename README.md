# Hello htmx

A collection of samples of what you can do with Spring Boot + Thymeleaf + htmx. 

- Load more contacts
- Add a new contact
- Delete a contact
- Search Contacts
- Bulk Update
- Sortable 


## Load More Contacts

This example demonstrates how to load more contacts using htmx. The initial page loads returns the `01/index.html`
 view which contains the first 3 contacts. When you click the load contacts button a call is made to the `_01/ContactsController` 
to request the next 3 contacts. The response is then inserted into the DOM using htmx.

![Load More Contacts](./images/load-more-contacts.png)

## 02 - Add new Contact (Coming Soon!)

This example demonstrates how to add a new contact using htmx. The initial page loads returns the `02/index.html`
 view which contains the initial list of users. When you click on the add user button a modal window will open with a form
allowing you to add a new user.

![Add New User](./images/add-new-user.png)