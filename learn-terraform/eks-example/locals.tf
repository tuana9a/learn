locals {
  aws_region           = "ap-southeast-1"
  aws_credential_files = ["~/.aws/credentials"]
  aws_profile_name     = "default"

  aws_key_pair_name            = "test"
  aws_key_pair_public_key_file = "~/.ssh/id_rsa.pub"
}
