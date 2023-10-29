# IAM

Identity and Access Management

**NOTE**: some parts of this node is copied from AWS docs

## IAM Identity

users, groups of users, or roles.

## Principal

A principal entity is a person or application that is ***authenticated*** using an IAM entity (user or role).

## Policy

For more details, see [Permission and Policy in IAM](https://docs.aws.amazon.com/IAM/latest/UserGuide/introduction_access-management.html)

You manage access in AWS by creating **policies** and **attaching** them to IAM identities (users, groups of users, or roles) or AWS resources.\
A policy is an object in AWS that, when associated with an identity or resource, defines their permissions.\
AWS evaluates these policies when a principal uses an IAM entity (user or role) to make a request.\
Permissions in the policies determine whether the request is allowed or denied.

### Policy and users

When you create an IAM user, they **can't** access anything in your account until you give them permission.\
You give permissions to a user by creating an **identity-based policy**, which is a policy that is attached to the user or a group to which the user belongs.

The following example shows a JSON policy that allows the user to perform all Amazon DynamoDB actions `(dynamodb:*)` on the `Books` table in the `123456789012` account within the `us-east-2` Region.

```json
{
  "Version": "2012-10-17",
  "Statement": {
    "Effect": "Allow",
    "Action": "dynamodb:*",
    "Resource": "arn:aws:dynamodb:us-east-2:123456789012:table/Books"
  }
}
```

After you attach this policy to your IAM user, the user only has those DynamoDB permissions. Most users have **multiple** policies that together represent the permissions for that user.

### Policy and group

You can organize IAM users into IAM groups and **attach** a policy to a group.\
**All** the users in a group **have** the permissions that are attached to the group.\
Individual users still have their own credentials.

### Identity-based and resource-based policies

**Identity-based** policies control what actions the identity can perform, on which resources, and under what conditions.\
Identity-based policies can be further categorized:

- **Managed policies** – Standalone identity-based policies that you can attach to multiple users, groups, and roles in your AWS account. You can use two types of managed policies:
  - **AWS managed policies** – Managed policies that are created and managed by AWS. If you are new to using policies, we recommend that you start by using AWS managed policies.
  - **Customer managed policies** – Managed policies that you create and manage in your AWS account. Customer managed policies provide more precise control over your policies than AWS managed policies. You can create, edit, and validate an IAM policy in the visual editor or by creating the JSON policy document directly. For more information, see Creating IAM policies and Editing IAM policies.
- **Inline policies** – Policies that you create and manage and that are embedded directly into a single user, group, or role. In most cases, we **don't recommend** using inline policies.

**Resource-based** policies control what actions a specified principal can perform on that resource and under what conditions.\
Resource-based policies are inline policies, and there are no managed resource-based policies.\
To enable cross-account access, you can specify an entire account or IAM entities in another account as the principal in a resource-based policy.

## Role

Roles provide temporary credentials that users can assume when needed. User can `switch role` to change the role temporarily.\
For example, we can create a role `TempBillingAccess` with prolicy `Billing`, then assign this role to the user `support`.\
Then the `support` user can use the `switch role` feature to gain access temporarily to the `Billing` feature.

**NOTE**: When switching to a different role, if admin dettaches the role from the IAM account,\
current user that switched role still has access to that role until that session expires.

Examples

```json
{
    "Version": "2012-10-17",
    "Statement": [
        {
            "Sid": "Statement1",
            "Effect": "Allow",
            "Principal": {
                "AWS": [
                    "arn:aws:iam::my-account-id:user/test",
                    "arn:aws:iam::my-account-id:user/support"
                ]
            },
            "Action": "sts:AssumeRole"
        }
    ]
}
```

IAM user `test` and `support` are allowed to switch to role `TempBillingAccess`
