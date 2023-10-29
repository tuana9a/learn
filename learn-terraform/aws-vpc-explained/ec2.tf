data "aws_ami" "ubuntu_server" {
  most_recent = true
  owners      = ["099720109477"] # Canonical

  filter {
    name   = "name"
    values = ["ubuntu/images/hvm-ssd/ubuntu-bionic-18.04-amd64-server-*"]
  }
}

resource "aws_key_pair" "key_pair_1" {
  key_name   = local.aws_key_pair_name
  public_key = file(local.aws_key_pair_public_key_file)
}


resource "aws_instance" "instance_1" {
  instance_type = "t2.micro"
  ami           = data.aws_ami.ubuntu_server.id
  subnet_id     = aws_subnet.subnet_1.id
  private_ip    = "10.0.1.11"
  key_name      = aws_key_pair.key_pair_1.id
  vpc_security_group_ids = [
    # aws_vpc.vpc_1.default_security_group_id,
    aws_security_group.sg_1.id
  ]

  root_block_device {
    volume_size = 8
    volume_type = "gp2"
  }
}

resource "aws_instance" "instance_2" {
  instance_type = "t2.micro"
  ami           = data.aws_ami.ubuntu_server.id
  subnet_id     = aws_subnet.subnet_2.id
  private_ip    = "10.0.2.12"
  key_name      = aws_key_pair.key_pair_1.id
  vpc_security_group_ids = [
    # aws_vpc.vpc_1.default_security_group_id,
    aws_security_group.sg_2.id # block every thing in the internet, even inside the same vpc
  ]

  root_block_device {
    volume_size = 8
    volume_type = "gp2"
  }
}

resource "aws_instance" "instance_22" {
  instance_type = "t2.micro"
  ami           = data.aws_ami.ubuntu_server.id
  subnet_id     = aws_subnet.subnet_2.id
  private_ip    = "10.0.2.122"
  key_name      = aws_key_pair.key_pair_1.id
  vpc_security_group_ids = [
    # aws_vpc.vpc_1.default_security_group_id,
    aws_security_group.sg_4.id # security group is stateless
  ]

  root_block_device {
    volume_size = 8
    volume_type = "gp2"
  }
}

resource "aws_instance" "instance_3" {
  instance_type = "t2.micro"
  ami           = data.aws_ami.ubuntu_server.id
  subnet_id     = aws_subnet.subnet_3.id
  private_ip    = "10.0.3.13"
  vpc_security_group_ids = [
    # aws_vpc.vpc_1.default_security_group_id,
    aws_security_group.sg_3.id # allow same vpc
  ]

  root_block_device {
    volume_size = 8
    volume_type = "gp2"
  }
}
