output "instance_1" {
  value = "private_ip ${aws_instance.instance_1.private_ip} public_ip ${aws_instance.instance_1.public_ip}"
}

output "instance_2" {
  value = "private_ip ${aws_instance.instance_2.private_ip} public_ip ${aws_instance.instance_2.public_ip}"
}

output "instance_22" {
  value = "private_ip ${aws_instance.instance_22.private_ip} public_ip ${aws_instance.instance_22.public_ip}"
}

output "instance_3" {
  value = "private_ip ${aws_instance.instance_3.private_ip} public_ip ${aws_instance.instance_3.public_ip}"
}
